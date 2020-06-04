package vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation.Controller.ICartController;
import vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation.Model.Product;

public class FirstFragment extends Fragment {

    RecyclerView rvListProduct;
    ProductAdapter adapter;
    List<Product> listProducts;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void addViews(){

        FragmentActivity activity = getActivity();

        rvListProduct = activity.findViewById(R.id.rvListProduct);
        rvListProduct.setLayoutManager(new LinearLayoutManager(activity));

        ICartController cartController = (ICartController) activity.getApplication();
        listProducts = cartController.getAllProducts();

        adapter = new ProductAdapter(listProducts);
        rvListProduct.setAdapter(adapter);

    }

    /*public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btnGioHang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        addViews();
    }

    //Lớp cài đặt cho việc hiển thị của một Product
    private class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtName, txtPrice, txtDesc;
        ImageView imvAddToCart;
        Product p;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtName);
            txtPrice = this.itemView.findViewById(R.id.txtPrice);
            txtDesc = this.itemView.findViewById(R.id.txtDesc);
            imvAddToCart = this.itemView.findViewById(R.id.imvAddToCart);
            imvAddToCart.setOnClickListener(this);
        }

        public void bind(Product p){
            this.p = p;
            txtName.setText(p.getName());
            txtPrice.setText(new Integer(p.getPrice()).toString() + " VND");
            txtDesc.setText(p.getDesc());
        }

        @Override
        public void onClick(View v) {
            int sum = 0;
            ICartController controller = (ICartController) getActivity().getApplication();
            if(controller.addToCart(p)){
                sum =  sum + this.txtPrice.length();
                Toast.makeText(getActivity(), "Thêm " + p.getName() + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getActivity(), p.getName() + " đã tồn tại trong giỏ hàng của bạn", Toast.LENGTH_SHORT).show();
        }
    }

    //Lớp Adapter kết nối RecycleView và dữ liệu
    private class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

        List<Product> listProducts;

        private ProductAdapter(List<Product> listProduct) {
            this.listProducts = listProduct;
        }

        //Tạo một ViewHolder để hiển thị dữ liệu
        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product, parent,false);
            //Product.xml
            return new ProductViewHolder(view);
        }

        //Kết nối một mục dữ liệu trong danh sách với một ViewHolder
        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(listProducts.get(position));
        }

        @Override
        public int getItemCount() {
            return listProducts.size();
        }
    }
}
