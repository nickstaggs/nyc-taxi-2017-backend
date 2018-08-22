WITH ride_counts AS
    (SELECT pickup_location_id, dropoff_location_id, COUNT(*) ride_count
    FROM rides
    GROUP BY pickup_location_id, dropoff_location_id)
UPDATE routes
    SET total_rides =
        (SELECT ride_count
        FROM ride_counts
        WHERE ride_counts.pickup_location_id = routes.pickup_location_id
        AND ride_counts.dropoff_location_id = routes.dropoff_location_id);

UPDATE routes SET total_rides = 0 WHERE total_rides IS NULL;