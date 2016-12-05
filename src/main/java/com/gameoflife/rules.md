**Input:**

- [x] RowxColumn
- [x] Generations >=0 (0 is infinite)
- [x] Initial live cells

**The Rules:**

- [x] For a space that is 'populated':
- [x] Each cell with one or no neighbors dies, as if by solitude.
- [x] Each cell with four or more neighbors dies, as if by overpopulation.
- [x] Each cell with two or three neighbors survives.
- [x] For a space that is 'empty' or 'unpopulated'
- [x] Each cell with three neighbors becomes populated.
- [x] Print matrix for every generation to console.