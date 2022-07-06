class User:
    def __init__(self, first_name, last_name, email, age):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = False
        self.gold_card_points = 0

    def display_info(self):
        print("First name:",self.first_name)
        print("Last name:",self.last_name)
        print("Email:", self.email)
        print("Age", self.age)
        print("Is rewards member?:", self.is_rewards_member)
        print("Gold card points", self.gold_card_points)

    def enroll(self):
        if self.is_rewards_member == True:
            print("User already a member")
            return False
        else: 
            self.is_rewards_member = True
            self.gold_card_points = 200

    def spend_points(self, amount):
        if amount > self.gold_card_points:
            print("Insufficient funds")
        else:
            self.gold_card_points -= amount
            
            print("transaction successful")


madhav = User("madhav", "asok", "madhavasok@gmail.com", 20)
madhav.display_info()
madhav.enroll()
jane = User("jane", "doe", "janedoe@gmail.com", 25)
john = User("john", "smith","johnsmith@hotmail.com", 30 )
madhav.spend_points(50)
jane.enroll()
jane.spend_points(80)
madhav.display_info()
jane.display_info()
john.display_info()
madhav.enroll()


