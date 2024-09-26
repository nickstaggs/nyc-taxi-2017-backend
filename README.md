## Backend of NYC-YellowTaxi

## How to run locally
1. `mvn compile && mvn clean package`
2. `docker compose up`

## Background info
This was inspired by this [post](https://toddwschneider.com/posts/analyzing-1-1-billion-nyc-taxi-and-uber-trips-with-a-vengeance/)

The full data set is [here](https://data.cityofnewyork.us/Transportation/2017-Yellow-Taxi-Trip-Data/biws-g3hs/about_data)

The postgres db in this repo has the rides data that you get from the full data set reconfigured into a routes table and
zones table and all the original ride data has been removed so it could be stored in github.

The routes table has a column that is the count of the total rides for each route

You can see the sql statements used to derive the data into its current state in the [db folder](/src/main/db)

The frontend is brought in as a submodule so the above commands bring up everything and then you just have to navigate to http://localhost:3000/