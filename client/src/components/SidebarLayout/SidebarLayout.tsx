import Box from "@mui/material/Box";
import CssBaseline from "@mui/material/CssBaseline";
import Divider from "@mui/material/Divider";
import Drawer from "@mui/material/Drawer";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import React, { useContext } from "react";
import GroupsIcon from "@mui/icons-material/Groups";
import HomeIcon from "@mui/icons-material/Home";
import PersonIcon from "@mui/icons-material/Person";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../../auth/AuthContextProvider";
import LogoutIcon from "@mui/icons-material/logout";

type SidebarItem = {
  text: string;
  link: string;
  icon?: any;
  requiresLogin: boolean;
  fn?: () => void;
};

type Props = {
  content: JSX.Element;
};
export default function SidebarLayout({ content }: Props) {
  const [mobileOpen, setMobileOpen] = React.useState(false);
  const drawerWidth = 240;
  const navigate = useNavigate();
  const auth = useContext(AuthContext);

  const isLoggedIn = auth.authProvider?.isAuthenticated;

  const sidebarItems: SidebarItem[] = [
    {
      text: "Home",
      link: "/",
      icon: HomeIcon,
      requiresLogin: false,
    },
    {
      text: "Players",
      link: "/players",
      icon: PersonIcon,
      requiresLogin: true,
    },
    {
      text: "Teams",
      link: "/teams",
      icon: GroupsIcon,
      requiresLogin: true,
    },
    {
      text: "Logout",
      link: "/",
      icon: LogoutIcon,
      requiresLogin: true,
      fn: auth.singOut,
    },
  ];

  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen);
  };

  const goTo = (si: SidebarItem) => {
    if (si.fn) {
      si.fn();
    }
    navigate(si.link);
  };

  const drawer = (
    <div>
      <Toolbar>
        <Typography variant="h5">Lob City Data</Typography>
      </Toolbar>
      <Divider />
      <List>
        {sidebarItems.map((item, index) =>
          item.requiresLogin ? (
            isLoggedIn && (
              <ListItem key={index} disablePadding>
                <ListItemButton onClick={() => goTo(item)}>
                  {item.icon && (
                    <ListItemIcon>
                      <item.icon />
                    </ListItemIcon>
                  )}
                  <ListItemText primary={item.text} />
                </ListItemButton>
              </ListItem>
            )
          ) : (
            <ListItem key={index} disablePadding>
              <ListItemButton onClick={() => goTo(item)}>
                {item.icon && (
                  <ListItemIcon>
                    <item.icon />
                  </ListItemIcon>
                )}
                <ListItemText primary={item.text} />
              </ListItemButton>
            </ListItem>
          )
        )}
      </List>
      <Divider />
    </div>
  );

  return (
    <Box sx={{ display: "flex" }}>
      <CssBaseline />
      <Box
        component="nav"
        sx={{ width: { sm: drawerWidth }, flexShrink: { sm: 0 } }}
        aria-label="mailbox folders"
      >
        <Drawer
          variant="temporary"
          open={mobileOpen}
          onClose={handleDrawerToggle}
          ModalProps={{
            keepMounted: true,
          }}
          sx={{
            display: { xs: "block", sm: "none" },
            "& .MuiDrawer-paper": {
              boxSizing: "border-box",
              width: drawerWidth,
            },
          }}
        >
          {drawer}
        </Drawer>
        <Drawer
          variant="permanent"
          sx={{
            display: { xs: "none", sm: "block" },
            "& .MuiDrawer-paper": {
              boxSizing: "border-box",
              width: drawerWidth,
            },
          }}
          open
        >
          {drawer}
        </Drawer>
      </Box>
      <Box
        component="main"
        sx={{
          flexGrow: 1,
          p: 3,
          width: { sm: `calc(100% - ${drawerWidth}px)` },
        }}
      >
        {content}
      </Box>
    </Box>
  );
}
