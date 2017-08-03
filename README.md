
## WeatherPredictorApp
Machine Learning model for weather prediction using Java

## Requirement
The problem was to develop a toy weather predictor which can generate weather conditions for a given location for a given time.


## Implementation - ML approach
The machine learning approach needs a data which is termed as Train_Data_Set OR Training_Data.There are lot of API services which provides historical weather data,which requires some data cleaning and formatting.Here the train_data_set used is in .csv format.
Prediction of weather includes prediction of the following four parameters.
1. Temperature
2. Pressure
3. Humidity
4. Weather condition (Rainy/Sunny/Snowy) 

The first three predicates are continuous values which needs a regression model for prediction, for which Multiple Linear Regression Model is used.
Here, ordinary least squares (OLS) is implemented to estimate the parameters of a multiple linear regression model.OLSMultipleLinearRegression from Commons Math 3.0 API is used.(org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression)

The weather condition can be either of Rain,Snow or Sunny, predicting which is a classification problem, for which Logistic regression methodology is used.Logistic regression is a supervised learning algorithm used to classify input data into categories.As we have three categories here , we are using multinomial logistic regression.The classification algorithm will use the trained model function and will return the probability for a new input data to be in a category or another. Online
Logistic regression from Apache Mahout 0.9 API is used.(org.apache.mahout.classifier.sgd.OnlineLogisticRegression)


## Prerequisites
JavaSE 1.8
Apache Maven 3.3.3
Eclipse Neon

## Application Installation and Run commands
To run the application, 

1.Build the maven project:
mvn clean install 

2.Run command:
java -jar <jarname> <latitude> <longitude> <elevation> <timestamp> <outputfileLocation>



