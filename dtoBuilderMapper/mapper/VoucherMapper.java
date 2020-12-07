@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = Configure.class)
public interface VoucherMapper {
  VoucherMapper INSTANCE = Mappers.getMapper(VoucherMapper.class);

  Voucher toEntity(VoucherDto.CreateReq createReq, Configure voucherTypeConfig);
  Voucher toEntity(VoucherDto.UpdateReq updateReq, Configure voucherTypeConfig);
  @Mappings({ @Mapping(target = "voucher.voucherType", source = "voucherTypeConfig") })
  Voucher update(@MappingTarget Voucher voucher, VoucherDto.UpdateReq updateReq, Configure voucherTypeConfig, Date updated);

  VoucherDto.CreateRes entityOfCreateRes(Voucher voucher);
  VoucherDto.UpdateRes entityOfUpdateRes(Voucher voucher);

}