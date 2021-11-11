package co.com.sofka.horseapp.infrastructure.materialize;

import co.com.sofka.horseapp.domain.lane.events.LaneCreated;
import co.com.sofka.horseapp.domain.game.events.GameCreated;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import co.com.sofka.horseapp.domain.game.events.GameFinished;
import co.com.sofka.horseapp.domain.game.events.GameStarted;
import co.com.sofka.horseapp.domain.game.events.PlayerAssigned;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class GameHandle {
    private final MongoClient mongoClient;

    public GameHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }


    @ConsumeEvent(value = "sofkau.game.gamecreated")
    void consumeGameCreated(GameCreated event) {
        System.out.println("materialize bill");
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("kilometers", event.getKilometers());
        document.put("numberOfLanes", event.getNumberOfLanes());
        document.put("isPlaying", event.getState());
        document.put("finalPosition", event.getCurrentFinalPosition());
        mongoClient.getDatabase("queries").getCollection("game")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofkau.game.playerassigned")
    void consumePlayerAssigned(PlayerAssigned event) {
        System.out.println("materialize product");
        BasicDBObject document = new BasicDBObject();
        var key = "jugadores."+event.getIdentificationCard();
        document.put(key+".cedula", event.getIdentificationCard());
        document.put(key+".nombre", event.getName());

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);
        mongoClient.getDatabase("queries").getCollection("game")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }

    @ConsumeEvent(value = "sofkau.game.gamestarted")
    void consumeGameStarted(GameStarted event) {
        System.out.println("materialize product");
        BasicDBObject document = new BasicDBObject();
        document.put("jugando", event.getState());
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);
        mongoClient.getDatabase("queries").getCollection("game")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }


    @ConsumeEvent(value = "sofkau.game.gamefinished")
    void consumeGameFinished(GameFinished event) {
        System.out.println("materialize product");
        BasicDBObject document = new BasicDBObject();
        document.put("jugando", event.getState());
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);
        mongoClient.getDatabase("queries").getCollection("game")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }

    @ConsumeEvent(value = "sofkau.lane.lanecreated")
    void consumeLaneCreated(LaneCreated event) {
        System.out.println("materialize carril");
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("meta", event.getGoal());
        document.put("juegoId", event.getGameId());
        mongoClient.getDatabase("queries").getCollection("lane")
                .insertOne(new Document(document));
    }

}