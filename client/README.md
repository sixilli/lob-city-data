## How things work

This project uses Vite as the build tool. It takes care of minifying the code for production builds and
also includes nice features that aid in the development process like hot module reloading.

- `package.json` Project settings, dependencies and run scripts live in here.
- `tsconfig.json` The typescript compiler uses this file to know how it should behave.

## How to build and run the project

First time building.

1. Install NodeJS
2. Open a terminal at the root of the project directory
3. Run the command `npm install`

Running the webapp.

1. Run the command `npm run dev`

## Project structure

- `src/components` This is where all the smallest pieces of the frontend will live. Examples of components: NavBar, DropDown, FormBody, SubmitButton, TableRow.
- `src/pages` Here is where components will be composed together. Pages will typically have their own HTTP route as well.
- `src/router` Code for the router so it won't bloat other areas of the code.

## Notable dependecies and what they do

React can involve a lot of boiler plate. So in order to cut down on
work that has been solved we'll add some dependencies.

- React Query: Simplifies fetching data and managing data fetching state changes within React
- Material UI: By far the most popular component library. This saves us for writing many small components ourselves like date pickers or buttons.
