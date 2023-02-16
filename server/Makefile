deploy:
	gcloud run deploy lob-city-data-api --port=8080 --source=.

run:
	mvn spring-boot:run

native:
	mvn spring-boot:build-image -Dspring-boot.build-image.imageName=alecperro/lobcitydata

artifact:
	docker push alecperro/lobcitydata