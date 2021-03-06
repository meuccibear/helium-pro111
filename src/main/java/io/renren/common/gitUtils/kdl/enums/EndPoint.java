package io.renren.common.gitUtils.kdl.enums;

public enum EndPoint {
    GetOrderExpireTime("dev.kdlapi.com/api/getorderexpiretime"),
    GetIpWhitelist("dev.kdlapi.com/api/getipwhitelist"),
    SetIpWhitelist("dev.kdlapi.com/api/setipwhitelist"),
    GetKpsProxy("kps.kdlapi.com/api/getkps"),
    GetDpsProxy("dps.kdlapi.com/api/getdps"),
    GetOpsProxyNormalOrVip("dev.kdlapi.com/api/getproxy"),
    GetOpsProxySvip("svip.kdlapi.com/api/getproxy"),
    GetOpsProxyEnt("ent.kdlapi.com/api/getproxy"),
    CheckDpsValid("dps.kdlapi.com/api/checkdpsvalid"),
    CheckOpsValid("dev.kdlapi.com/api/checkopsvalid"),
    GetIpBalance("dps.kdlapi.com/api/getipbalance"),
    GetDpsValidTime("dps.kdlapi.com/api/getdpsvalidtime");

    private String value;

    private EndPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
