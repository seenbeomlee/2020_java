@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VoucherDto {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class CreateReq {
    @NotBlank
    private String name;
    @NotBlank
    private String organization;
    @NotBlank
    // 회원 유형 ON. OFF
    private String regitType;
    @NotNull
    private String voucherType;

    @NotNull
    private Boolean general;
    @NotNull
    private Boolean infants;
    @NotNull
    private Boolean mother;

    public Voucher toEntity(Configure voucherTypeConfig) {
      return VoucherMapper.INSTANCE.toEntity(this, voucherTypeConfig);
    }
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class UpdateReq {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String organization;
    @NotBlank
    // 회원 유형 ON. OFF
    private String regitType;
    @NotNull
    private String voucherType;

    @NotNull
    private Boolean general;
    @NotNull
    private Boolean infants;
    @NotNull
    private Boolean mother;

    public Voucher toEntity(Configure voucherTypeConfig) {
      return VoucherMapper.INSTANCE.toEntity(this, voucherTypeConfig);
    }
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class CreateRes {
    private String name;
    private String organization;
    // 회원 유형 ON. OFF
    private String regitType;
    private Configure voucherType;

    private Boolean general;
    private Boolean infants;
    private Boolean mother;

    public static CreateRes of(Voucher voucher) {
      return VoucherMapper.INSTANCE.entityOfCreateRes(voucher);
    }
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class UpdateRes {
    private String id;
    private String name;
    private String organization;
    // 회원 유형 ON. OFF
    private String regitType;
    private Configure voucherType;

    private Boolean general;
    private Boolean infants;
    private Boolean mother;

    public static UpdateRes of(Voucher voucher) {
      return VoucherMapper.INSTANCE.entityOfUpdateRes(voucher);
    }
  }
}
