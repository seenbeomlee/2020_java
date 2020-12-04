public interface VoucherRepository extends CrudRepository<Voucher, Long> {
  Voucher findByIdAndCenterId(String id, String centerId);
  List<Voucher> findByCenterIdAndStateOrderByCreatedDesc(String centerId, String state);
  Voucher findById(String id);
}
