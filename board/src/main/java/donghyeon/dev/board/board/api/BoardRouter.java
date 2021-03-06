package donghyeon.dev.board.board.api;

import donghyeon.dev.board.board.application.BoardHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
public class BoardRouter {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(BoardHandler boardHandler) {

        return nest(path("/board"),
                route(GET("/"),boardHandler::getAllBoard)
                .andRoute(GET("/{id}"),boardHandler::getOneBoard)
                .andRoute(POST("/"),boardHandler::createBoard)
//                .andRoute(PATCH("/{id}"),boardHandler::updateBoard)
                .andRoute(DELETE("/{id}"),boardHandler::deleteBoard));
    }
}
