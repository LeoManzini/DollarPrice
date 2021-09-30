# DollarPrice
Java API that returns the actual dollar price and have a consult to old dates.

## Technologies
 - Java 11
 - Spring Boot 2.5.5
 - Maven 4.0.0

## How it works

The project, that could be found at ```DollarPricing``` folder, is an ```API``` that receive the data about the dollar price from another ```API``` named as 
```API de Cotações de Moedas```, you can found the documentation and more about at this url ```https://docs.awesomeapi.com.br/api-de-moedas```, all the credits goes
to the API owner.

The code use two methods from this ```API```, the ```get``` method that returns the dollar price in real time, called as 
```Retorna moedas selecionadas (atualizado a cada 30 segundos)``` and the ```get``` method to load the history cotation, based on an especific data 
```Retorna cotações sequenciais de um período específico```.

![real-time-price](https://user-images.githubusercontent.com/39606289/135367436-38279125-a2a3-4104-b3dd-2c5b0a1cf174.png)

![history-price](https://user-images.githubusercontent.com/39606289/135367475-ea0a592a-f70e-4321-a670-cf6ac8ac42f5.png)

## Compiling

How the code is made using ```maven``` as dependency manager, we use the command ```clean package -X``` to compile the source code.

![maven-compile](https://user-images.githubusercontent.com/39606289/135367661-1a131394-b200-4f05-9b1c-59d2ffa19807.png)

## Running

To start the service, you can use two running methods, starting the same inside of your IDE, or running the binary file that the compilation generate.

### Running at IDE

To run at your IDE, just start the spring boot application, you doesn't need to choose the profile you want to use during your run, because the code has an automatic choice
based on the environment that the code is running, at this case I used only the ```dev``` profile, the ```prod``` profile was made just with the purpose of show my skills.

![starting-at-ide](https://user-images.githubusercontent.com/39606289/135368106-a59eafac-dec4-4e1f-80c8-de8afd547864.png)

After the project is up, you can access the features with this endpoint to the real time dollar price ```http://localhost:8080/price```, and the history feature at the 
same endpoint, but passing a data to search ```http://localhost:8080/price/dd/mm/aaaa```.

![real-time-endpoint](https://user-images.githubusercontent.com/39606289/135368803-0f14168b-3cc2-4882-b737-985aca652744.png)

![history-endpoint](https://user-images.githubusercontent.com/39606289/135368861-5adf0a80-9797-4fa9-a4e0-e597aed994e0.png)

To run at the IDE, remember to uncomment the lines below, these lines made the Java use the correct path to access the properties.

![properties](https://user-images.githubusercontent.com/39606289/135369078-e0a3e42a-7c7f-47d0-aeac-f0f41d7a7917.png)

### Runnig from binary file

This step can only be made, once that the code has been compiled, like told at the ```Compiling``` section.

To execute the code from the terminal, use the command line ```java -jar DollarPrice.jar```, this will start the service.

![terminal](https://user-images.githubusercontent.com/39606289/135369365-042c3619-7771-4485-b76b-c83e55d610fb.png)

The endpoints and so on, works as the same the IDE execution.

## Database

All the data received from requests are persisted at PostgreSql database, the script to create the database and user that we used on this code are at the folder 
```DatabaseScripts``` and at the file ```create-database```. Execute the same commands at PostgreSql plsql terminal, and our database is working and the data being persisted.

![database-script](https://user-images.githubusercontent.com/39606289/135371018-d4ed0886-191a-4955-86e5-dd5c1d811a80.png)

![java-configurations](https://user-images.githubusercontent.com/39606289/135371063-ae45d185-ee37-4e6a-aeb4-02296258b276.png)
