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

TODO INSERT ENDPOINTS PRINTSCREEN
