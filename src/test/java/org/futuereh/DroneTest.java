package org.futuereh;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.quarkus.test.junit.QuarkusTest;
import org.futuereh.dto.DroneDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;

@QuarkusTest
public class DroneTest {

  @Test
  @DisplayName("1 - Add drone")
  public void save() {
    DroneDto droneDto = new DroneDto();
    droneDto.setAlias("Perseus Red");
    droneDto.setBrandName("Xiaomi");
    droneDto.setModel("A940");
    droneDto.setDelivery(null);
    droneDto.setLatitude(23.5558f);
    droneDto.setLongitude(46.6396f);
    droneDto.setActive(false);

    given().body(droneDto).contentType(ContentType.JSON).post("/drone").then().statusCode(201);
  }

  @Test
  @DisplayName("2 - List all drones")
  public void listAll() {
    DroneDto droneDto1 = new DroneDto();
    droneDto1.setAlias("Perseus Red");
    droneDto1.setBrandName("Xiaomi");
    droneDto1.setModel("A940");
    droneDto1.setDelivery(null);
    droneDto1.setLatitude(23.5558f);
    droneDto1.setLongitude(46.6396f);
    droneDto1.setActive(false);

    DroneDto droneDto2 = new DroneDto();
    droneDto2.setAlias("Vim Black");
    droneDto2.setBrandName("Lenovo");
    droneDto2.setModel("CC500");
    droneDto2.setDelivery(null);
    droneDto2.setLatitude(23.5558f);
    droneDto2.setLongitude(46.6396f);
    droneDto2.setActive(false);

    given().body(droneDto1).contentType(ContentType.JSON).post("/drone");
    given().body(droneDto2).contentType(ContentType.JSON).post("/drone");

    given().when().get("/drone").then().statusCode(200).body("list.size()", is(5));
  }

  @Test
  @DisplayName("3 - Find drone by id")
  public void findById() {
    DroneDto droneDto = new DroneDto();
    droneDto.setAlias("Perseus Red");
    droneDto.setBrandName("Xiaomi");
    droneDto.setModel("A940");
    droneDto.setDelivery(null);
    droneDto.setLatitude(23.5558f);
    droneDto.setLongitude(46.6396f);
    droneDto.setActive(false);

    given().body(droneDto).contentType(ContentType.JSON).post("/drone").then().statusCode(201);
    given().when().get("/drone/3").then().statusCode(200).body("alias", is("Perseus Red"));
  }

  @Test
  @DisplayName("4 - Update drone")
  public void update() {
    DroneDto droneDto = new DroneDto();
    droneDto.setAlias("Perseus Red");
    droneDto.setBrandName("Xiaomi");
    droneDto.setModel("A940");
    droneDto.setDelivery(null);
    droneDto.setLatitude(23.5558f);
    droneDto.setLongitude(46.6396f);
    droneDto.setActive(false);

    given().body(droneDto).contentType(ContentType.JSON).post("/drone").then().statusCode(201);
    given().body(droneDto).contentType(ContentType.JSON).put("/drone/2").then()
            .statusCode(200);
  }

  @Test
  @DisplayName("5 - Delete drone")
  public void delete() {
    DroneDto droneDto = new DroneDto();
    droneDto.setAlias("Perseus Red");
    droneDto.setBrandName("Xiaomi");
    droneDto.setModel("A940");
    droneDto.setDelivery(null);
    droneDto.setLatitude(23.5558f);
    droneDto.setLongitude(46.6396f);
    droneDto.setActive(false);

    given().body(droneDto).contentType(ContentType.JSON).post("/drone").then().statusCode(201);
    given().when().get("/drone").then().statusCode(200).body("list.size()", is(1));

    given().delete("/drone/1");
    given().when().get("/drone").then().statusCode(200).body("list.size()", is(0));
  }
}
