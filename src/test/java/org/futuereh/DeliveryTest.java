package org.futuereh;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.quarkus.test.junit.QuarkusTest;
import org.futuereh.entity.DeliveryEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;

import java.time.LocalDateTime;

@QuarkusTest
public class DeliveryTest {

  @Test
  @DisplayName("1 - Add delivery")
  public void save() {
    DeliveryEntity delivery = new DeliveryEntity();
    delivery.setWithdrawalDate(LocalDateTime.now());
    delivery.setDeliveryDate(LocalDateTime.now());
    delivery.setStatus(true);

    given().body(delivery).contentType(ContentType.JSON).post("/delivery").then().statusCode(201);
  }

  @Test
  @DisplayName("2 - List all deliverys")
  public void listAll() {
    DeliveryEntity delivery1 = new DeliveryEntity();
    delivery1.setWithdrawalDate(LocalDateTime.now());
    delivery1.setDeliveryDate(LocalDateTime.now());
    delivery1.setStatus(true);

    DeliveryEntity delivery2 = new DeliveryEntity();
    delivery2.setWithdrawalDate(LocalDateTime.now());
    delivery2.setDeliveryDate(LocalDateTime.now());
    delivery2.setStatus(false);

    given().body(delivery1).contentType(ContentType.JSON).post("/delivery");
    given().body(delivery2).contentType(ContentType.JSON).post("/delivery");

    given().when().get("/delivery").then().statusCode(200).body("list.size()", is(5));
  }

  @Test
  @DisplayName("3 - Find delivery by id")
  public void findById() {
    DeliveryEntity delivery = new DeliveryEntity();
    delivery.setWithdrawalDate(LocalDateTime.now());
    delivery.setDeliveryDate(LocalDateTime.now());
    delivery.setStatus(true);

    given().body(delivery).contentType(ContentType.JSON).post("/delivery").then().statusCode(201);
    given().when().get("/delivery/3").then().statusCode(200).body("status", is(true));
  }

  @Test
  @DisplayName("4 - Update delivery")
  public void update() {
    DeliveryEntity delivery = new DeliveryEntity();
    delivery.setWithdrawalDate(LocalDateTime.now());
    delivery.setDeliveryDate(LocalDateTime.now());
    delivery.setStatus(true);

    given().body(delivery).contentType(ContentType.JSON).post("/delivery").then().statusCode(201);
    given().body(delivery).contentType(ContentType.JSON).patch("/delivery/2").then()
            .statusCode(200);
  }

  @Test
  @DisplayName("5 - Delete delivery")
  public void delete() {
    DeliveryEntity delivery = new DeliveryEntity();
    delivery.setWithdrawalDate(LocalDateTime.now());
    delivery.setDeliveryDate(LocalDateTime.now());
    delivery.setStatus(true);

    given().body(delivery).contentType(ContentType.JSON).post("/delivery").then().statusCode(201);
    given().when().get("/delivery").then().statusCode(200).body("list.size()", is(1));

    given().delete("/delivery/1");
    given().when().get("/drone").then().statusCode(200).body("list.size()", is(0));
  }
}
