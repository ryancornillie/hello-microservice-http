package io.vertx.book.http;

import io.vertx.core.AbstractVerticle;

public class HelloMicroservice extends AbstractVerticle {

    @Override
    public void start() {

        Router router = Router.router(vertex);
        router.get("/").handler(rc -> rc.response().end("hello"));
        router.get("/:name").handler(rc -> rc.response()
            .end("hello " + rc.pathParam("name")));
        
        vertx.createHttpServer()
            .requestHandler(router:accept)
            .listen(8080);
    }

}
