package io.github.douglasjr97.quarkusapi;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "API Quarkus",
                version = "1.0",
                contact = @Contact(
                        name = "Douglas Falcão",
                        url = "https://douglas-falcao.netlify.app/"
                )

        )
)
public class QuarkusApiApplication extends Application {



}
