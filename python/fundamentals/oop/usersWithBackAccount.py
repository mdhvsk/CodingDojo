class BankAccount:

    instancesList = []

    def __init__(self, int_rate, balance=0):
        self.int_rate = int_rate
        self.balance = balance
        BankAccount.instancesList.append(self)

    def display_account_info(self):
        print("Interest rate:", self.int_rate)
        print("Balance:", self.balance)
        return self

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if self.balance - amount < 0:
            print("insufficient funds. Charging a $5 Fee")
            self.balance -= 5
        else:
            self.balance -= amount
        return self

    def yield_interest(self):
        self.balance += self.balance * self.int_rate
        return self

    @classmethod
    def print_all_instances(cls):
        for instant in cls.instancesList:
            # print(instant)
            print("Interest rate:", instant.int_rate)
            print("Balance", instant.balance)


class User:
    def __init__(self, first_name, last_name, email, age, accountType):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = False
        self.gold_card_points = 0
        self.account = {accountType:BankAccount(int_rate=0.2, balance = 0)}

    def display_info(self, accountType):
        print("First name:",self.first_name)
        print("Last name:",self.last_name)
        print("Email:", self.email)
        print("Age", self.age)
        print("Is rewards member?:", self.is_rewards_member)
        print("Gold card points", self.gold_card_points)
        print("Accounts:", self.account)
        return self

    def enroll(self):
        if self.is_rewards_member == True:
            print("User already a member")
            return False
        else: 
            self.is_rewards_member = True
            self.gold_card_points = 200
        return self

    def spend_points(self, amount):
        if amount > self.gold_card_points:
            print("Insufficient funds")
        else:
            self.gold_card_points -= amount
            
            print("transaction successful")
        return self

    def makeDeposit(self, amount,accountType):
        self.account[accountType].deposit(amount)
        # print(self.account[accountType].balance)
        return self

    def makeWithdrawal(self, amount, accoutType):
        self.account[accoutType].withdraw(amount)
        return self
    
    def display_user_balance(self, accountType):
        print(self.account[accountType].balance)
        return self
    
    def addAccount(self,accountType):
        self.account[accountType] = BankAccount(int_rate=0.2, balance = 0)
        return self

    def verifyAccount(self,accountType):
        print(self.account[accountType].balance)

        return self

    def transfer_money(self, amount, other_user, otherAccountType, myAccountType):
        other_user.makeWithdrawal(amount, otherAccountType)
        self.makeDeposit(amount, myAccountType)
        return self

checking = "checking"
savings = "savings"
a1 = User("madhav", "asok", "madhavasok@gmail.com", 25, checking)
a1.verifyAccount(checking).makeDeposit(200,checking).addAccount(savings).makeDeposit(300, savings)

a2 = User("sanket", "dange", "sanketdange@gmail.com", 21, savings)
a2.verifyAccount(savings).makeDeposit(1000, savings)

a1.verifyAccount(checking).transfer_money(400, a2, savings, checking).verifyAccount(checking)