package org.teamorigin.sa.user.impl;

import akka.Done;
import akka.NotUsed;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.teamorigin.sa.user.api.User;
import org.teamorigin.sa.user.api.UserService;

import java.util.concurrent.CompletableFuture;


    public class UserImpl implements UserService {

        private UserRepository userRepository;

        @Inject
        public UserImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public ServiceCall<NotUsed, User> getUserById(String id) {

            return request -> CompletableFuture
                    .completedFuture(userRepository.getUserById(id));
        }

        @Override
        public ServiceCall<User, Done> addUser() {

            return request ->{
                userRepository.addUser(request);
                return CompletableFuture.completedFuture(Done.getInstance());
            };
        }

    }

