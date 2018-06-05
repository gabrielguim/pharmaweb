import {
  Dashboard,
  ContentPaste,
  Notifications
} from "@material-ui/icons";

const dashboardRoutes = [
  {
    path: "/",
    sidebarName: "Dashboard",
    navbarName: "Material Dashboard",
    icon: Dashboard,
  },
  {
    path: "/products",
    sidebarName: "Table List",
    navbarName: "Table List",
    icon: ContentPaste
  },
  {
    path: "/notifications",
    sidebarName: "Notifications",
    navbarName: "Notifications",
    icon: Notifications
  }
];

export default dashboardRoutes;
