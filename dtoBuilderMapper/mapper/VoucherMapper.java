@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = Configure.class)
public interface VoucherMapper {
  VoucherMapper INSTANCE = Mappers.getMapper(VoucherMapper.class);

  Voucher toEntity(VoucherDto.CreateReq createReq, Configure voucherTypeConfig);
  Voucher toEntity(VoucherDto.UpdateReq updateReq, Configure voucherTypeConfig);

  VoucherDto.CreateRes entityOfCreateRes(Voucher voucher);
  VoucherDto.UpdateRes entityOfUpdateRes(Voucher voucher);

}
