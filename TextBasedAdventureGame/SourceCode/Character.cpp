#include "Character.h"

Character::Character(){
    this->name = " ";
    this->health = 1;
    this->greeting = " Welcome to Beyond the South East\n By Sean Ryan and Eoin Costello";
}

Character::Character(string name, int health){
    this->name = name;
    this->health = health;
}

string Character::getName(){
    return this->name;
}
void Character::setName(string name){
    this->name = name;
}

int Character::getHealth(){
    return this->health;
}
void Character::setHealth(int health){
    this->health = health;
}

string Character::getGreeting()
{
    return this->greeting;
}
