package pdp.uz.appclickup.entity.enums;

import java.util.Arrays;
import java.util.List;

public enum WorkspacePermissionName {
    CAN_ADD_OR_REMOVE_MEMBER("Add/Remove Members","Gives user permission  to add or remove members the workspace",
            Arrays.asList(WorkSpaceRoleName.ROLE_ADMIN,WorkSpaceRoleName.ROLE_MEMBER)),
    CAN_MANAGE_STATUS("Edit Statuses","Gives user permission...",
            Arrays.asList(WorkSpaceRoleName.ROLE_MEMBER,WorkSpaceRoleName.ROLE_ADMIN)),
    CAN_ADD_GUEST("CAN_ADD_GUEST",
                          "Gives the user the permission to remove members to the Workspace",
                  Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_SEE_TIME_ESTIMATED("CAN_SEE_TIME_ESTIMATED",
                                   "Gives the user the permission to remove members to the Workspace",
                           Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_SEE_TIME_SPENT("CAN_SEE_TIME_SPENT",
                               "Gives the user the permission to remove members to the Workspace",
                       Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_CREATE_SPACES("CAN_CREATE_SPACES",
                              "Gives the user the permission to remove members to the Workspace",
                      Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_CREATE_FOLDER("CAN_CREATE_FOLDER",
                              "Gives the user the permission to remove members to the Workspace",
                      Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_CREATE_LISTS("CAN_CREATE_LISTS",
                             "Gives the user the permission to remove members to the Workspace",
                     Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_DELETE_COMMENTS("CAN_DELETE_COMMENTS",
                                "Gives the user the permission to remove members to the Workspace",
                        Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_DELETE_ITEMS("CAN_DELETE_ITEMS",
                             "Gives the user the permission to remove members to the Workspace",
                     Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_EDIT_DESCRIPTION("CAN_EDIT_DESCRIPTION",
                                 "Gives the user the permission to remove members to the Workspace",
                         Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_ADD_LIST_STATUSES("CAN_ADD_LIST_STATUSES",
                                  "Gives the user the permission to remove members to the Workspace",
                          Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_EDIT_LIST_STATUSES("CAN_EDIT_LIST_STATUSES",
                                   "Gives the user the permission to remove members to the Workspace",
                           Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_EDIT_TEAM("CAN_EDIT_TEAM",
                          "Gives the user the permission to remove members to the Workspace",
                  Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_EXPORT_TASKS("CAN_EXPORT_TASKS",
                             "Gives the user the permission to remove members to the Workspace",
                     Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_EDIT_TEAM_OWNER("CAN_EDIT_TEAM_OWNER",
                                "Gives the user the permission to remove members to the Workspace",
                        Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_MANAGE_TAGS("CAN_MANAGE_TAGS",
                            "Gives the user the permission to remove members to the Workspace",
                    Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN, WorkSpaceRoleName.ROLE_MEMBER)
    ),
    CAN_SHARE("CAN_SHARE",
                      "Gives the user the permission to remove members to the Workspace",
              Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN, WorkSpaceRoleName.ROLE_MEMBER)
    ),
    CAN_MANAGE_STATUSES("CAN_MANAGE_STATUSES",
                                "Gives the user the permission to remove members to the Workspace",
                        Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_SEE_TEAM_MEMBERS("CAN_SEE_TEAM_MEMBERS",
                                 "Gives the user the permission to remove members to the Workspace",
                         Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_ADD_ROLE("CAN_ADD_ROLE",
                         "Gives the user the permission to remove members to the Workspace",
                 Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    ),
    CAN_CHANGE_PERMISSION("CAN_CHANGE_PERMISSION",
                                  "Gives the user the permission to remove members to the Workspace",
                          Arrays.asList(WorkSpaceRoleName.ROLE_OWNER, WorkSpaceRoleName.ROLE_ADMIN)
    );

    private String name;
    private String description;
    private List<WorkSpaceRoleName> workSpaceRoleNameList;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<WorkSpaceRoleName> getWorkSpaceRoleNameList() {
        return workSpaceRoleNameList;
    }

    WorkspacePermissionName(String name, String description, List<WorkSpaceRoleName> workSpaceRoleNameList) {
        this.name = name;
        this.description = description;
        this.workSpaceRoleNameList=workSpaceRoleNameList;
    }
}
