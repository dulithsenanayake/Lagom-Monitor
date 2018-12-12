package org.teamorigin.sa.user.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.topic;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;
import com.lightbend.lagom.javadsl.api.broker.kafka.KafkaProperties;

public interface UserService extends Service{

    public ServiceCall<NotUsed, User> getUserById(String id);
    public ServiceCall<User,Done> addUser();
    public ServiceCall<NotUsed,Done> removeUser(String id);

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("user").withCalls(
                pathCall("/api/user/:id",  this::getUserById),
                pathCall("/api/user/save",  this::addUser),
                pathCall("/api/user/delete/:id",  this::removeUser)
        ).withAutoAcl(true);
        // @formatter:on
    }

}

