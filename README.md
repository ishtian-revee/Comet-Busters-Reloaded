# Comet Busters Reloaded

Comet Busters Reloaded is a PC game developed in Java programming language. The
game concept is actually familiar with the real **'Comet Busters'** game which
is more likely a space shooter game. This is why the name of this game is same
as **'Comet Busters'** with just a extend part of 'reloaded'. But this game has
limited features and levels than **'Comet Busters'**. But users will find the
gameplay quite similar.

## Development and Resources

This game is developed in raw Java programming language. No game engines or any
types of game development frameworks have been used in this. The main components
of Java that has been used in this game developments are:

* JFrame
* Java AWT Libraries
* Java Swing Libraries

---

Tools used: `Eclipse IDE` `Adobe Fireworks`

Game Assets: `Kenney`
Background Music: `Geoplex`

All the game components textures has been cropped from a single sprite sheet
which is in `res/textures/sheet.png`. There are also some other textures and
icons in the directory which has been downloaded from google.

`res/audio/` contains all the game sounds and background music. All these files
are in .mp3 extension.

---

For some game implementation additional Libraries has been used in this project.
All these additional libraries are in `lib/` directory.

## Gameplay and concept

After a smooth splash screen main menu state appears. User will find total of
4 options in the main menu which are **start game**, **high scores**, **option**
and **exit game**.

After starting the game users will have full on control over the player to move
from one place to other and shoot lasers.

Controls:

Up: `W` or `up arrow`

Down: `S` or `down arrow`

Left: `A` or `left arrow`

Right: `D` or `right arrow`

Shoot laser: `space`

Pause: `ESC`

### Start Game

When the level starts there will be some comets coming from upwards in random
direction. These comets will roam between the game screen. What user has to do
is shoot at these comets to destroy them and again avoid these from collision
or else player will loose a life.

Some times after destroying a comet player will have some powerups to collect.
These powerups could be +life, +xp and so on.

Initially the player will have total of 3 lives, single laser beam and no ship
mode and also score of 0. By destroying comets player will some points which
will added to the scores. And also by getting powerups player will have xp,
additional life, more laser power and ship modes.

This game has total of **20 Levels**. In each level different size, types and
numbers of comets will appear. In the initial levels the number of comets are
less. But when the player move forward to the next levels the difficulty level
gets higher. The number of comets increases.

If the player loose all of its life the game over. After game over user has to
input their name in 3 letters (roll up and down like slots to input the username)
and enter. The score along with the name will store in the high score table.
