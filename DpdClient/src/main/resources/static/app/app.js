(function(angular) {
  angular.module("dpdApp.controllers", ["ui-notification"]);
  angular.module("dpdApp.services", []);
  // angular.module("dpdApp", ["ngResource", "ngSanitize", "ui.select", "dpdApp.controllers", "dpdApp.services"]);
  angular.module("dpdApp", ["ngResource", "localytics.directives", "dpdApp.controllers", "dpdApp.services"]);
}(angular));