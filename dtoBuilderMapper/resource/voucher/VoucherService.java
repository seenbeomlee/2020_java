@Service
public class VoucherService {
	Logger logger = LoggerFactory.getLogger(VoucherService.class);

  @Autowired
	VoucherRepository voucherRepository;
  @Autowired
	ConfigureRepository configureRepository;

	public VoucherDto.CreateRes saveVoucherInfo(VoucherDto.CreateReq reqDto) {
		Configure voucherType = configureRepository.findByConfigName(reqDto.getVoucherType());
		Voucher newVoucher = voucherRepository.save(reqDto.toEntity(voucherType));

		return VoucherDto.CreateRes.of(newVoucher);
	}

	public VoucherDto.UpdateRes updateVoucherInfo(VoucherDto.UpdateReq reqDto) throws Exception {
		Configure voucherType = configureRepository.findByConfigName(reqDto.getVoucherType());
		Voucher targetVoucher = getVoucherInfoById(reqDto.getId());

		targetVoucher.updateFromReqDto(reqDto, voucherType);

		return VoucherDto.UpdateRes.of(voucherRepository.save(targetVoucher));
  }
}
