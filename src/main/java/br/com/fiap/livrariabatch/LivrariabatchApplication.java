//package br.com.fiap.livrariabatch;
//
//import java.io.File;
//import java.nio.file.Paths;
//
//import javax.sql.DataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.Resource;
//
//@SpringBootApplication
//@EnableBatchProcessing
//public class LivrariabatchApplication {
//
//	Logger logger = LoggerFactory.getLogger(LivrariabatchApplication.class);
//	public static void main(String[] args) {
//		SpringApplication.run(LivrariabatchApplication.class, args);
//	}
//
//	//	================== Tasklet STEP ======================
//	
//	@Bean
//	public Tasklet tasklet(@Value("${file.path}") String filePath) {
//		return (contribution, chuckContext) -> {
//			File file = Paths.get(filePath).toFile();
//			if(file.delete()) {
//				logger.info("Arquivo deletado com sucesso.");
//			}else {
//				logger.info("Não foi possível deletar o arquivo.");
//			}
//			
//			return RepeatStatus.FINISHED;
//		};
//		
//	}
//	
//	@Bean
//	public Step step(Tasklet tasklet, StepBuilderFactory stepBuilderFactory) {
//		return stepBuilderFactory.get("Delete Step")
//				.tasklet(tasklet)
//				.allowStartIfComplete(true)
//				.build();
//	}
//	
//	@Bean
//	public Job job(Step step, JobBuilderFactory jobBuilderFactory) {
//		return jobBuilderFactory.get("Delete Job")
//				.start(step)
//				.build();
//	}
//	
//
//}
