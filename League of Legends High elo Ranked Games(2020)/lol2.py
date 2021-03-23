# -*- coding: utf-8 -*-
"""
Created on Fri Jan  8 04:44:12 2021

@author: HSM
"""

import pandas as pd
import numpy as np
from sklearn.pipeline import Pipeline
from sklearn.pipeline import make_pipeline
from sklearn.linear_model import LogisticRegression
from sklearn.linear_model import LinearRegression 
from sklearn.ensemble import GradientBoostingRegressor
from sklearn.ensemble import RandomForestRegressor
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split, cross_validate, GridSearchCV
from sklearn.metrics import accuracy_score, precision_score, recall_score, plot_roc_curve, roc_curve,classification_report,confusion_matrix


data = pd.concat([
    pd.read_csv('GrandMaster_Ranked_Games.csv'),
    pd.read_csv('Challenger_Ranked_Games.csv'),
    pd.read_csv('Master_Ranked_Games.csv'),
])

print(data.info())


blueColumns = [x for x in data.columns if x.startswith('blue') and x.endswith('Wins') == False]
redColumns = [x for x in data.columns if x.startswith('red') and x.endswith('Wins') == False]
redColumns.remove("redFirstBlood")
redColumns.remove("redFirstTower")
redColumns.remove("redFirstBaron")
redColumns.remove("redFirstDragon")
redColumns.remove("redFirstInhibitor")

redAndBlue = blueColumns + redColumns

x = data.loc[:,redAndBlue]
y = data.iloc[:,2]

blueFeatures = data.loc[:,blueColumns]

x_train, x_test, y_train, y_test = train_test_split(x, y, random_state=42)
#x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.2)
pipe = make_pipeline(StandardScaler(), LogisticRegression())
pipe.fit(x_train, y_train)  # apply scaling on training data
Pipeline(steps=[('standardscaler', StandardScaler()),
                ('logisticregression', LogisticRegression())])
print(pipe.score(x_train, y_train))
print(pipe.score(x_test, y_test))
resultPredict = pipe.predict(x_test.iloc[3:4,:])
#finalResult = resultPredict.iloc[0]
print(type(resultPredict))
print(x_test.columns)
thelist = np.array([[1, 0, 0, 0, 1, 1, 0, 10, 2, 41, 12, 38, 23, 71, 92033, 54928, 527, 71, 14.2, 116, 6, 27746, 45509, 5, 0, 3, 0, 45, 10, 22, 38, 29, 74162, 47000, 489, 66, 13.2, 121, 4, 24830, 46287]])

print("Predict game is: "+str(pipe.predict(thelist)))



from flask import Flask
from flask import request
app=Flask(__name__)
@app.route('/')
def helloWorld():
    print(__name__)
    return 'Hello HSM, I\'m here\!'

@app.route('/one')
def helloOne():
    return 'Hello One'


@app.route('/newRow',methods=["POST"])
def newRow():
    
    blueFirstBlood = int(request.form['blueFirstBlood'])
    blueFirstTower = int(request.form['blueFirstTower'])
    blueFirstBaron = int(request.form['blueFirstBaron'])
    blueFirstDragon = int(request.form['blueFirstDragon'])
    blueFirstInhibitor = int(request.form['blueFirstInhibitor'])
    blueDragonKills = int(request.form['blueDragonKills'])
    blueBaronKills = int(request.form['blueBaronKills'])
    blueTowerKills = int(request.form['blueTowerKills'])
    blueInhibitorKills = int(request.form['blueInhibitorKills'])
    blueWardPlaced = int(request.form['blueWardPlaced'])
    blueWardKills = int(request.form['blueWardKills'])
    blueKills = int(request.form['blueKills'])
    blueDeath = int(request.form['blueDeath'])
    blueAssist = int(request.form['blueAssist'])
    blueChampionDamageDealt = int(request.form['blueChampionDamageDealt'])
    blueTotalGold = int(request.form['blueTotalGold'])
    blueTotalMinionKills = int(request.form['blueTotalMinionKills'])
    blueTotalLevel = int(request.form['blueTotalLevel'])
    blueAvgLevel = float(request.form['blueAvgLevel'])
    blueJungleMinionKills = int(request.form['blueJungleMinionKills'])
    blueKillingSpree = int(request.form['blueKillingSpree'])
    blueTotalHeal = int(request.form['blueTotalHeal'])
    blueObjectDamageDealt = int(request.form['blueObjectDamageDealt'])
    
    redDragonKills = int(request.form['redDragonKills'])
    redBaronKills = int(request.form['redBaronKills'])
    redTowerKills = int(request.form['redTowerKills'])
    redInhibitorKills = int(request.form['redInhibitorKills'])
    redWardPlaced = int(request.form['redWardPlaced'])
    redWardKills = int(request.form['redWardKills'])
    redKills = int(request.form['redKills'])
    redDeath = int(request.form['redDeath'])
    redAssist = int(request.form['redAssist'])
    redChampionDamageDealt = int(request.form['redChampionDamageDealt'])
    redTotalGold = int(request.form['redTotalGold'])
    redTotalMinionKills = int(request.form['redTotalMinionKills'])
    redTotalLevel = int(request.form['redTotalLevel'])
    redAvgLevel = float(request.form['redAvgLevel'])
    redJungleMinionKills = int(request.form['redJungleMinionKills'])
    redKillingSpree = int(request.form['redKillingSpree'])
    redTotalHeal = int(request.form['redTotalHeal'])
    redObjectDamageDealt = int(request.form['redObjectDamageDealt'])
    
    thelist = np.array([[blueFirstBlood, blueFirstTower, blueFirstBaron, blueFirstDragon, blueFirstInhibitor,
                         blueDragonKills, blueBaronKills, blueTowerKills, blueInhibitorKills, blueWardPlaced, blueWardKills,
                         blueKills, blueDeath, blueAssist, blueChampionDamageDealt, blueTotalGold, blueTotalMinionKills,
                         blueTotalLevel, blueAvgLevel, blueJungleMinionKills, blueKillingSpree, blueTotalHeal, blueObjectDamageDealt,
                         redDragonKills, redBaronKills, redTowerKills, redInhibitorKills, redWardPlaced, redWardKills, 
                         redKills, redDeath, redAssist, redChampionDamageDealt, redTotalGold, redTotalMinionKills, 
                         redTotalLevel, redAvgLevel, redJungleMinionKills, redKillingSpree, redTotalHeal, redObjectDamageDealt]])
    result = str(pipe.predict(thelist))
    print(result)
    return result

@app.route('/two',methods=["POST"])
def helloTwo():
    result = request.form['test']
    return result

if __name__=="__main__":
    app.run(host='0.0.0.0')
