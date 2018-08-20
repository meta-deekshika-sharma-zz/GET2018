#Identify the columns require indexing in order, product, category tables and create indexes.

ALTER TABLE Category ADD INDEX categoryIndex(Id);
ALTER TABLE Product ADD INDEX productIndex(Id);
ALTER TABLE Orders ADD INDEX orderIndex(Id);