#include <iostream>
#include <fstream>
#include <sstream>
#include <list>
#include <vector>
#include<bits/stdc++.h>
using namespace std;

#define INF HUGE_VAL

class node{
  public:
  node() {x = 0; y = 0; z = 0;}
  node(double x, double y, double z){
    this->x = x;
    this->y = y;
    this->z = z;
  }

  double getX() const {return x;}
  double getY() const {return y;}
  double getZ() const {return z;}

  private:
  double x, y, z;
};

typedef list<int> adjList;
typedef vector<adjList> graph;
typedef vector<node> coords;
  
void readGraph(graph&, string);
void readGraphCoords(coords&, string);
void printGraph(const graph);
void largestDegree(const graph);
void averageDegree(const graph);
void neighbours(const graph, int);
void neighbours(const graph, int, int);
void shortestPath(const graph, string, int, int);
void shortestEdgeCount(const graph, int, int);
double distXY(const coords, int, int);

int n, m;

int main(int argc, char *argv[])
{

  string country;
  int q, v1, v2, k;
  graph g;

  getline(cin, country);
  cin >> q;

  readGraph(g, country);

  switch (q){
    case 1:
      cout << "n= " << n << "; m= " << m << ".\n";
      break;

    case 2:
      largestDegree(g);
      break;

    case 3:
      averageDegree(g);
      break;

    case 4:
      cin >> v1;
      neighbours(g, v1);
      break;

    case 5:
      cin >> v1;
      cin >> k;
      neighbours(g, v1, k);
      break;

    case 6:
      cin >> v1;
      cin >> v2;
      shortestPath(g, country, v1, v2);
      break;

    case 7:
      cin >> v1;
      cin >> v2;
      shortestEdgeCount(g, v1, v2);
      break;

    default:
      cout << "Unknown query; exiting.\n";
  }
}

void readGraph(graph& g, string country){
    string line;
    ifstream GraphFile(country.append(".osm.graph"));

    getline (GraphFile, line);
    while ((line.find("%")) != std::string::npos){
        getline (GraphFile, line);
    }

    istringstream os(line);
    os >> n;
    os >> m;
    
    while (getline (GraphFile, line)) {
      adjList neighbours;
      istringstream n(line);

      int next;
      while(n >> next){
          neighbours.push_back(next);
      }
      g.push_back(neighbours);
    }
    
   GraphFile.close();
}

void readGraphCoords(coords& c, string country){
    string line;
    ifstream CoordinateFile(country.append(".osm.xyz"));

    while (getline (CoordinateFile, line)) {
      istringstream n(line);
      double x, y, z;
      n >> x;
      n >> y;
      n >> z;
      c.push_back(node(x,y,z));
    }

    CoordinateFile.close();
}

void largestDegree(const graph g){
    int count = 0, nv = 0, v = 0;

    graph::const_iterator adjIt;

    for(adjIt = g.begin(); adjIt != g.end(); adjIt++){
        adjList n = *adjIt;
        adjList::const_iterator nit;


        int nCount = 0;
        for(nit = n.begin(); nit != n.end(); nit++){
            nCount++;
        }
        if(nCount > nv){ nv = nCount; v = count; }
         count++;
    }
    cout << "v= " << v + 1 << "; |N(v)|= " << nv << ".\n";
}

void averageDegree(const graph g){
    float vCount = 0, total = 0;

    graph::const_iterator adjIt;

    for(adjIt = g.begin(); adjIt != g.end(); adjIt++){
        adjList n = *adjIt;
        adjList::const_iterator nit;

        for(nit = n.begin(); nit != n.end(); nit++){
            total++;
        }
        vCount++;
    }
    cout << "avg |N(v)|= " << fixed << setprecision(6) << total / vCount << ".\n";
}

void neighbours(const graph g, int vertex){
    adjList n = g[vertex - 1];
    adjList::const_iterator nit;

    cout << "N(" << vertex << ")=";
    for(nit = n.begin(); nit != n.end(); nit++){
        cout << " " << *nit;
    }

    cout << ".\n";
}

void neighbours(const graph g, int vertex, int distance){
    vector<int> currentNeighbours = {vertex};
    adjList::const_iterator nit;

    for(int d = distance; d > 0; d--){
        vector<int> nextNeighbours;
	
        for(int i = 0; i < (int)currentNeighbours.size(); i++){
            adjList n = g[currentNeighbours[i] - 1];	    
	    
            for(nit = n.begin(); nit != n.end(); nit++){
                if(count(nextNeighbours.begin(), nextNeighbours.end(), *nit) == 0){
                    nextNeighbours.push_back(*nit);
                }
            }
        }
        currentNeighbours = nextNeighbours;
    }
    sort(currentNeighbours.begin(), currentNeighbours.end());

    cout << "N(" << vertex << "," << distance << ")=";
    for(auto x : currentNeighbours){ cout << " " << x; }
    cout << ".\n";
}

void shortestPath(const graph g, string country, int v1, int v2){
    coords coordinates;
    readGraphCoords(coordinates, country);

    bool visited[n];
    float distance[n];
    for(int i = 0; i < n; i++){ visited[i] = false; distance[i] = INF; }

    int curr = v1;
    distance[curr - 1] = 0.0;
    bool found = false;

    while(!found){

        vector<int>unvisited;
        for(int i = 0; i < n; i++){
            if(!visited[i] && distance[i] != INF){
                unvisited.push_back(i+1);
            }
        }
        curr = unvisited[0];
        for(auto i : unvisited){
            if(distance[i - 1] < distance[curr - 1]){
                curr = i;
            }
        }

        adjList n = g[curr - 1];
        adjList::const_iterator nit;
        for(nit = n.begin(); nit != n.end(); nit++){
            if(!visited[(*nit) - 1] && *nit != curr){
                double d = distXY(coordinates, curr, *nit);
                if(d + distance[curr - 1] < distance[*nit - 1]){
                    distance[*nit - 1] = (d + distance[curr - 1]);
                }
            }
        }
        visited[curr - 1] = true;
        if(curr == v2){ found = true; }
    }

    cout << "d(" << v1 << "," << v2 << ")= " << fixed << setprecision(6) << distance[v2 - 1] << ".\n";
}

void shortestEdgeCount(const graph g, int v1, int v2){
    int edgeCount = 0;
    vector<int> neighboursPassed;
    vector<int> currentNeighbours = {v1};
    adjList::const_iterator nit;

    bool search = true;
    while(search){
        vector<int> nextNeighbours;
        for(int i = 0; i < (int)currentNeighbours.size(); i++){
            adjList n = g[currentNeighbours[i] - 1];

            for(nit = n.begin(); nit != n.end(); nit++){
                if(*nit == v2){search = false;}
                if(count(neighboursPassed.begin(), neighboursPassed.end(), *nit) == 0){
                    neighboursPassed.push_back(*nit);
                    nextNeighbours.push_back(*nit);
                }
            }
        }
        edgeCount++;
        currentNeighbours = nextNeighbours;
    }

    cout << "ed(" << v1 << "," << v2 << ")= " << edgeCount << ".\n";
}

void printGraph(const graph g){
    graph::const_iterator adjIt;
    for(adjIt = g.begin(); adjIt != g.end(); adjIt++){
        adjList n = *adjIt;
        adjList::const_iterator nit;
        for(nit = n.begin(); nit != n.end(); nit++){
            cout << *nit;
        }
        cout << endl;
    }
}

double distXY(coords c, int a, int b){
    double x1, x2, y1, y2;
    x1 = c[a - 1].getX();
    y1 = c[a - 1].getY();
    x2 = c[b - 1].getX();
    y2 = c[b - 1].getY();
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}
