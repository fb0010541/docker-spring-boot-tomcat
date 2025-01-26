package qq.benson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class DockerSpringBootTomcatApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringBootTomcatApplication.class, args);
	}

}
