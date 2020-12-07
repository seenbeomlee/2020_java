@Service
public class VoucherService {
	Logger logger = LoggerFactory.getLogger(VoucherService.class);

  @Autowired
	VoucherRepository voucherRepository;
  @Autowired
	ConfigureRepository configureRepository;
	
	public Voucher getVoucherInfoById(String id) throws Exception {
		return voucherRepository.findById(id);
	}

	public List<Voucher> getVoucherInfo() throws Exception {
		return voucherRepository.findByCenterIdAndStateOrderByCreatedDesc(FMSFactory.getCenterId(), GlobalVariable.ENABLE);
	}

	public VoucherDto.CreateRes saveVoucherInfo(VoucherDto.CreateReq reqDto) {
		Configure voucherType = configureRepository.findByConfigName(reqDto.getVoucherType());
		Voucher newVoucher = voucherRepository.save(reqDto.toEntity(voucherType));

		return VoucherDto.CreateRes.of(newVoucher);
	}

	public VoucherDto.UpdateRes updateVoucherInfo(VoucherDto.UpdateReq reqDto) throws Exception {
		Configure voucherType = configureRepository.findByConfigName(reqDto.getVoucherType());
		Voucher targetVoucher = getVoucherInfoById(reqDto.getId());

		targetVoucher.update(reqDto, voucherType, new Date());

		return VoucherDto.UpdateRes.of(voucherRepository.save(targetVoucher));
  }

  public Voucher disableVoucher(String voucherId) throws Exception{
		Voucher voucher = voucherRepository.findById(voucherId);
		voucher.setState(GlobalVariable.DISABLE);
		voucher.setUpdated(new Date());

		return voucherRepository.save(voucher);
	}
}
