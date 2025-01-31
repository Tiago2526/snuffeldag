import turtle

# Variabelen om de tekening te veranderen
background_color = "black"
pen_color = "yellow"
fill_color = "gold"
pen_size = 2
star_size = 150
num_points = 5

# Instellen van het scherm
screen = turtle.Screen()
screen.bgcolor(background_color)

# Aanmaken van de schildpad
star = turtle.Turtle()
star.color(pen_color)
star.pensize(pen_size)

# Tekenen van de ster met gevulde punten
star.begin_fill()  # Begin met het vullen van de vorm
star.fillcolor(fill_color)  # Stel de vulkleur in

for _ in range(num_points):
    star.forward(star_size)
    star.right(144)  # Hoek voor een ster met 5 punten

star.end_fill()  # Eindig met het vullen van de vorm

# Tekening voltooien
turtle.done()