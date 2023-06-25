# ser316-assignment5-sjgarc20

# Preliminary Plan

**Main driver: Singleton (Creational)**

  There's only one driver and all other object behavior should be facilitated through this driver. As such a singleton is perfect because it is ideal for a single instantiation of an object.
  
**Player, NPCs, and Weapons: State (Behavioral)**

  Player and NPC objects should have seperate states to handle status effects and buffs. Weapons should have state design patterns for a portion to allow for applying status effects, but a separate design pattern for the overall structure.
  
**Weapons: Abstract (Creational)**

  Weapons will need this design pattern because I intend to create various classes of weapons that will all be unique, even amongst other weapons of the same class.
  
**Weapons: Decorator (Structual)**

  Weapons will need to be customizable, allowing for unique effects that can be stacked and combined to produce interesting effects. This will encourage the player to get creative when customizing it and reward creative thinking over dumb luck.
  
