class BankAccount:

    instancesList = []

    def __init__(self, int_rate, balance = 0):
        self.int_rate = int_rate
        self.balance = balance

        BankAccount.instancesList.append(self)

    
    def display_account_info(self):
        print("Interest rate:", self.int_rate)
        print("Balance:", self.balance)
        return self

    def deposit(self,amount):
        self.balance += amount
        return self
    
    def withdraw(self,amount):
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
            print("Interest rate:",instant.int_rate)
            print("Balance", instant.balance)
            

a1 = BankAccount(0.01)
a2 = BankAccount(0.02, 20)


a1.deposit(50).deposit(100).withdraw(40).yield_interest().display_account_info()
a2.deposit(400).deposit(75).withdraw(25).withdraw(50).withdraw(100).withdraw(200).yield_interest().display_account_info()


print("BONUS QUESTION: ")
BankAccount.print_all_instances()