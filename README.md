
## WeatherPredictorApp
Machine Learning model for weather prediction using Java

## Requirement
The problem was to develop a toy weather predictor which can generate weather conditions for a given location for a given time.


## The ML approach
Train_data_set / training_data  - input for the machine learning approach.

Prediction of temperature,pressure,humidity - Linear regression methodology (OLRMultipleLinearRegression from apache commons is used)

Prediction of climate(Rainy/Sunny/Snowy) - Logistic regression methodology (Logisticregression from apache Mahout is used)


## Prerequisite
JavaSE 1.8
Apache Maven 3.3.3
Eclipse neon

## Getting Started
To run the application, 
Build the maven project - mvn clean install 
Run command - java -jar <jarname> <latititude> <longitude> <elevation> <timestamp> <outputfileLocation>



