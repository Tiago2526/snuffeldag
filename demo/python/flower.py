import turtle

# Variables to change the drawing
background_color = "lightblue"
pen_color = "purple"
fill_color = "pink"
pen_size = 3
petal_length = 100
num_petals = 6

# Setting up the screen
screen = turtle.Screen()
screen.bgcolor(background_color)

# Creating the turtle
flower = turtle.Turtle()
flower.color(pen_color)
flower.pensize(pen_size)

# Drawing the flower with filled petals
flower.begin_fill()  # Start filling the shape
flower.fillcolor(fill_color)  # Set the fill color

for _ in range(num_petals):
    flower.circle(petal_length, 60)  # Draw the first half of the petal
    flower.left(120)                 # Turn the turtle to draw the second half of the petal
    flower.circle(petal_length, 60)  # Draw the second half of the petal
    flower.left(360 / num_petals)    # Turn the turtle to start the next petal

flower.end_fill()  # End filling the shape

# Finish drawing
turtle.done()