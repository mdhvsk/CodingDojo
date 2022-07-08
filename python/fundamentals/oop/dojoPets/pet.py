class Pet:
    def __init__(self, name, type, tricks):
        self.name = name
        self.type = type
        self.tricks = tricks
        self.health = 50
        self.energy = 0
        

    def sleep(self):
        self.energy += 25
        print("I got sleep")

    def eat(self):
        self.energy += 5
        self.health += 10
        print("I ate")
    
    def play(self):
        self.health += 5
        print("I ran")
    
    def noise(self):
        print("AY I WAULKIN HERE!")
