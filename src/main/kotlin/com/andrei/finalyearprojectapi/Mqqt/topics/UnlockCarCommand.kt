package com.andrei.finalyearprojectapi.Mqqt.topics

import com.hivemq.client.mqtt.datatypes.MqttQos
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient
import org.springframework.stereotype.Component





@Component
class UnlockCarCommand (
    private val client: Mqtt5BlockingClient,
) {

    val route: String =  "/cars/%d/unlock"

     fun execute(carID:Long) {
         val path = route.format(carID)
         client.publishWith()
             .topic(path)
             .qos(MqttQos.AT_LEAST_ONCE)
             .send()
    }


}