players = [
    {
        "name": "Kevin Durant",
        "age": 34,
        "position": "small forward",
        "team": "Brooklyn Nets"
    },
    {
        "name": "Jason Tatum",
        "age": 24,
        "position": "small forward",
        "team": "Boston Celtics"
    },
    {
        "name": "Kyrie Irving",
        "age": 32, "position": "Point Guard",
        "team": "Brooklyn Nets"
    },
    {
        "name": "Damian Lillard",
        "age": 33, "position": "Point Guard",
        "team": "Portland Trailblazers"
    },
    {
        "name": "Joel Embiid",
        "age": 32, "position": "Power Foward",
        "team": "Philidelphia 76ers"
    },
    {
        "name": "",
        "age": 16,
        "position": "P",
        "team": "en"
    }
]



class Player:
    def __init__(self, playerDict):
        self.name = playerDict["name"]
        self.age = playerDict["age"]
        self.position = playerDict["position"]
        self.team = playerDict["team"]
    @classmethod
    def get_team(cls, team_list):
        team_players = []
        for i in range(len(team_list)):
            team_players.append(Player(team_list[i]))
        return team_players

x = Player.get_team(players)
print(x)

kevin1 = Player(players[0])
jason1 = Player(players[1])
kyrie1 = Player(players[2])

kevin = {
    "name": "Kevin Durant",
    "age": 34,
    "position": "small forward",
    "team": "Brooklyn Nets"
}
jason = {
    "name": "Jason Tatum",
    "age": 24,
    "position": "small forward",
    "team": "Boston Celtics"
}
kyrie = {
    "name": "Kyrie Irving",
    "age": 32, "position": "Point Guard",
    "team": "Brooklyn Nets"
}

# Create your Player instances here!
# player_jason = ???

player_kevin = Player(kevin)
player_jason = Player(jason)
player_kyrie = Player(kyrie)

new_team = []
playerNum = 1
for i in range(len(players)):
    playerName = "Player" + str(playerNum)
    playerNum += 1

    new_team.append(Player(players[i]))

