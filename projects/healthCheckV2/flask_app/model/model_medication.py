import math
from flask import flash
from flask_app.config.mysqlconnection import connectToMySQL


class Medication:

    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.dosage_mg = data['dosage_mg']
        self.dosage_pills = data['dosage_pills']
        self.total_pills = data['total_pills']
        self.pills_count = data['pill_count']
        self.days_of_week = data['days_of_week']
        self.times_of_day = data['times_of_day']
        self.comment = data['comment']
        self.user_id = data['user_id']
        self.days_of_week_list = []
        self.times_of_day_list = []
        self.days_till_refill = math.floor((len(self.days_of_week_list) * len(self.times_of_day_list)))

    @staticmethod
    def validateAddMeds(data):
        is_valid = True
        if len(data['name']) < 2:
            is_valid = False
        return is_valid

    @staticmethod
    def calculateDays(data):
        comparionArr = ['freqS', "freqM", "freqTu", "freqW", "freqTh", "freqF", "freqSa"]
        newArr = []
        for i in comparionArr:
            if i in data:
                newArr.append(i)
        bitSum = 0
        for i in newArr:
            bitSum += int(data[i])
        return bitSum

    @staticmethod
    def calculateTimes(data):
        comparionArr = ['timeM', "timeA", "timeE", "timeN"]
        newArr = []    
        for i in comparionArr:
            if i in data:
                newArr.append(i)    
        bitSum = 0
        for i in newArr:
            bitSum += int(data[i])        
        return bitSum

    @classmethod
    def insertMeds(cls, data):
        query = "INSERT INTO medications (name, dosage_mg, dosage_pills, comment, total_pills, pill_count, days_of_week, times_of_day, user_id) values(%(name)s, %(dosage_mg)s, %(dosage_pills)s, %(comment)s, %(total_pills)s, %(pill_count)s, %(days_of_week)s, %(times_of_day)s, %(user_id)s)"
        newID = connectToMySQL("health_check").query_db(query, data)
        return newID

    @classmethod
    def getAllMeds(cls):
        query = "SELECT * from medications"
        result = connectToMySQL("health_check").query_db(query)
        meds = []

        for medicine in result:
            meds.append(cls(medicine))
        
        for i in meds:
            print(i)
            totalDayBit = int(i.days_of_week)
            print(totalDayBit)
            if totalDayBit >= 64:
                totalDayBit = totalDayBit - 64
                i.days_of_week_list.append("Saturday")
            if totalDayBit >= 32:
                totalDayBit = totalDayBit - 32
                i.days_of_week_list.append("Friday")
                print('yes')
            if totalDayBit >= 16:
                totalDayBit = totalDayBit - 16
                i.days_of_week_list.append("Thursday")
            if totalDayBit >= 8:
                totalDayBit = totalDayBit - 8
                i.days_of_week_list.append("Wednesday")
            if totalDayBit >= 4:
                totalDayBit = totalDayBit - 4
                i.days_of_week_list.append("Tuesday")
            if totalDayBit >= 2:
                totalDayBit = totalDayBit - 2
                i.days_of_week_list.append("Monday")
            if totalDayBit >= 1:
                totalDayBit = totalDayBit - 1
                i.days_of_week_list.append("Sunday")
            i.days_of_week_list = i.days_of_week_list[::-1]
            
            totalTimeBit = i.times_of_day
            if totalTimeBit >= 8:
                totalTimeBit = totalTimeBit - 8
                i.times_of_day_list.append("Night")
            if totalTimeBit >= 4:
                totalTimeBit = totalTimeBit - 4
                i.times_of_day_list.append("Evening")
            if totalTimeBit >= 2:
                totalTimeBit = totalTimeBit - 2
                i.times_of_day_list.append("Afternoon")
            if totalTimeBit >= 1:
                totalTimeBit = totalTimeBit - 1
                i.times_of_day_list.append("Morning")
            i.times_of_day_list = i.times_of_day_list[::-1]
            i.days_till_refill = math.floor(i.pills_count * 7 / (len(i.days_of_week_list) * len(i.times_of_day_list)))
        return meds

    @staticmethod
    def takeMedication(data):
        query = "UPDATE medications SET pill_count = pill_count-1 WHERE id = %(id)s"
        connectToMySQL("health_check").query_db(query, data)
        return 

