## How things work
Most work won't be done in the main directory. Everything here focuses on how the application is built and ran. 
Our project uses Vite to compile our project and has nice features like hot module reloading.

`package.json` Project settings, dependencies and run scripts live in here.
`tsconfig.json` The typescript compiler uses this file to know how it should behave.

## How to build and run the project
First time building.
1. Install NodeJS
2. Open a terminal at the root of the project directory
3. Run the command `npm install`

Running the webapp.
1. Run the command `npm dev`

## Project structure
- `src/components` This is where all the smallest pieces of the frontend will live. Examples of components: NavBar, DropDown, FormBody, SubmitButton, TableRow.
- `src/pages` Here is where components will be composed together.
- `src/scripts` Work heavy code that would bloat the pages so it's moved somewhere else.

## Notable dependecies and what they do
React can involve a lot of boiler plate. So in order to cut down on
work that has been solved we'll add some dependencies. 
- React Query: Simplifies fetching data and managing data fetching state changes within React
- Material UI: By far the most popular component library. This saves us for writing many small components ourselves like date pickers.