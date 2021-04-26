#include "Player.h"
#include "GetMin.cpp"
#define LIMIT 100

Player::Player(){
    this->name = "player";
    this->health = 100;
    this->inventorySize = 0;
    inventory.push_back(Item("coins", "A small collection of coins", 10, 1, false, false));
}

Player::Player(string name, int health)
{
    this->name = name;
    this->health = health;
}

void Player::setHealth(int health){
    this->health = GetMin(health, LIMIT);
}


bool Player::isFull(int weight){
    if(this->inventorySize + weight < 100){
        return false;
    }
    return true;
}

void Player::takeItem(Item item){
    inventory.push_back(item);
    inventorySize += item.getWeight();
}
bool Player::hasItem(string itemName){
    for(int n = 0; n < (int) inventory.size(); n++){
        if(itemName.compare(inventory[n].getItem()) == 0){
            return true;
        }
    }
    return false;
}
Item Player::getItem(string itemName){
    for(int n = 0; n < (int) inventory.size(); n++){
        if(itemName.compare(inventory[n].getItem()) == 0){
            return inventory[n];
        }
    }
    return Item("","",0,0,false,false);
}
void Player::removeItem(string itemName){
    for(int n = 0; n < (int) inventory.size(); n++){
        if(itemName.compare(inventory[n].getItem()) == 0){
            inventorySize -= (inventory[n].getWeight());
            inventory.erase(inventory.begin() + n);
        }
    }
}

string Player::items(){
    string output = "";
    for(int n = 0; n < (int) inventory.size(); n++){
        output += (inventory[n]).getItem() + " ";
    }
    return output;
}

void Player::addCoins(Item item){
     Item c = getItem("coins") + item;
     removeItem("coins");
     takeItem(c);
}
void Player::removeCoins(Item item){
     Item c = getItem("coins") - item;
     removeItem("coins");
     takeItem(c);
}

int Player::getCoins(){
    for(int n = 0; n < (int) inventory.size(); n++){
       if(inventory[n].getItem().compare("coins") == 0){
           return inventory[n].getValue();
       }
    }
    return 0;
}
