import turtle

# Variabelen om de tekening te veranderen
background_color = "skyblue"
pen_color = "brown"
fill_color = "yellow"
roof_color = "red"
pen_size = 3
house_width = 200
house_height = 150

# Instellen van het scherm
screen = turtle.Screen()
screen.bgcolor(background_color)

# Aanmaken van de schildpad
house = turtle.Turtle()
house.color(pen_color)
house.pensize(pen_size)

# Tekenen van de basis van het huis
house.begin_fill()  # Begin met het vullen van de vorm
house.fillcolor(fill_color)  # Stel de vulkleur in

house.forward(house_width)
house.left(90)
house.forward(house_height)
house.left(90)
house.forward(house_width)
house.left(90)
house.forward(house_height)
house.left(90)

house.end_fill()  # Eindig met het vullen van de vorm

# Verplaatsen naar de dakpositie
house.left(90)
house.forward(house_height)
house.right(90)

# Tekenen van het dak
house.color(pen_color)
house.begin_fill()  # Begin met het vullen van de vorm
house.fillcolor(roof_color)  # Stel de vulkleur in

house.right(30)
house.forward(house_width / 2)
house.right(120)
house.forward(house_width / 2)
house.right(120)
house.forward(house_width / 2)

house.end_fill()  # Eindig met het vullen van de vorm

# Tekening voltooien
turtle.done()