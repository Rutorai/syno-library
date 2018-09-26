#!/bin/bash

echo "" > ./insert.sql

# Ajout de 50 recettes
for i in {1..50}
do
    echo "insert into t_recipe values ($i, 'Recette n$i', 'Description de cette merveilleuse recette n$i');" >> ./insert.sql
done

# Ajout de 15 magazines
for i in {1..15}
do
    echo "insert into t_magazine values ($i, 'Magasine n$i', 'Description de ce merveilleux magasine n$i');" >> ./insert.sql
done
