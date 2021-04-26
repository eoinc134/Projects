#include "NPC.h"
#include <iostream>

NPC::NPC(string name, int health, bool hostile, int damage, string greeting){
    this->name = name;
    this->health = health;
    this->hostile = hostile;
    this->damage = damage;
    this->greeting = greeting;
}

bool NPC::isHostile(){
    return this->hostile;
}
void NPC::setHostility(bool hostile){
    this->hostile = hostile;
}
int NPC::getDamage(){
    return this->damage;
}
string NPC::getGreeting(){
    return this->greeting;
}

string NPC::getStock(){
    return s.showStock();
}
bool NPC::hasItem(string item){
    return s.hasItem(item);
}
Item NPC::getItem(string item){
    return s.buyItem(item);
}
void NPC::removeItem(string item){
    s.removeItem(item);
}
