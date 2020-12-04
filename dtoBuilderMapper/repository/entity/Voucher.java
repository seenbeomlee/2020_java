@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Voucher {

  @ApiModelProperty(value="바우처 ID")
  @Id
  @Length(max = 32)
  @Column(nullable = false)
  private String id;

  @ApiModelProperty(value="센터 ID")
  @Length(max = 32)
  @Column(nullable = false)
  private String centerId;

  @ApiModelProperty(value="바우처 이름")
  private String name;

  @ApiModelProperty(value="바우처 타입")
  @ManyToOne(targetEntity = Configure.class)
  @JoinColumn(name="voucherType")
  private Configure voucherType;

  @ApiModelProperty(value="바우처 유형 임산부")
  private Boolean mother;

  @ApiModelProperty(value="바우처 유형 영유아")
  private Boolean infants;

  @ApiModelProperty(value="바우처 유형 일반")
  private Boolean general;

  @ApiModelProperty(value="바우처 유형 ON, OFF 타입")
  private String regitType;

  @ApiModelProperty(value="바우처 발급 기관")
  private String organization;

  @ApiModelProperty(value="바우처 상태 Disable, Enable")
  private String state;

  @ApiModelProperty(value="바우처 등록 일자")
  private Date created;

  @ApiModelProperty(value="바우처 갱신 일자")
  private Date updated;


  @Builder
  private Voucher(String name, String organization, String regitType, boolean general, boolean infants, boolean mother, Configure voucherTypeConfig) {
    this.name = name;
    this.organization = organization;
    this.regitType = regitType;
    this.voucherType = voucherTypeConfig; // FK, name should be different with 'voucherType' which already exists at VoucherDto.CreateReq(String voucherType)

    this.general = general;
    this.infants = infants;
    this.mother = mother;

    this.id = FMSFactory.uuid();
    this.centerId = FMSFactory.getCenterId();
    this.state = GlobalVariable.ENABLE;
    this.created = new Date();
    this.updated = new Date();
  }

  public void updateFromReqDto(VoucherDto.UpdateReq reqDto, Configure voucherTypeConfig) {
    this.name = reqDto.getName();
    this.organization = reqDto.getOrganization();
    this.regitType = reqDto.getRegitType();
    this.voucherType = voucherTypeConfig; // FK

    this.general = reqDto.getGeneral();
    this.infants = reqDto.getInfants();
    this.mother = reqDto.getMother();

    this.updated = new Date();
  }
}
