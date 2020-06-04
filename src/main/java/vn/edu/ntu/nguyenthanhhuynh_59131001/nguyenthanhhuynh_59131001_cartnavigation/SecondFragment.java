package vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

import vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation.Controller.ICartController;
import vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation.Model.Product;

public class SecondFragment extends Fragment implements View.OnClickListener {

    TextView txtShoppingCart;
    Button btnSubmit, btnCancel;
    String message = "Không có mặt hàng nào trong giỏ hàng của bạn";
    int productNumber;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(productNumber > 0){
                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_ThirdFragment);
                }
                else
                    txtShoppingCart.setText(message);
            }
        });

        view.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //productNumber = 0;

                FragmentActivity activity = getActivity();

                //Xóa tất cả sản phẩm
                ICartController controller = (ICartController) activity.getApplication();
                controller.clearShoppingCart();

                //Thông báo xóa thành công
                txtShoppingCart.setText(message);
                Toast.makeText(getActivity(), "Xóa giỏ hàng thành công", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.btnAddProduct).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        addView();
    }

    private void addView(){
        FragmentActivity activity = getActivity();

        txtShoppingCart = activity.findViewById(R.id.txtShoppingCart);

        //btnSubmit = activity.findViewById(R.id.btnSubmit);
        //btnCancel = activity.findViewById(R.id.btnCancel);

        //btnSubmit.setOnClickListener(this);
        //btnCancel.setOnClickListener(this);

        showShoppingCart();
    }

    public void showShoppingCart(){
        FragmentActivity activity = getActivity();
        ICartController controller = (ICartController) activity.getApplication();
        List<Product> products = controller.getShoppingCart();
        StringBuilder builder = new StringBuilder();

        productNumber = 0;
        for (Product p : products) {
            productNumber++;
            builder.append(p.getName())
                    .append(": \t\t\t")
                    .append(p.getPrice())
                    .append("\n");
        }

        if(builder.length() > 0)
            txtShoppingCart.setText(builder.toString());
        else
            txtShoppingCart.setText(this.message);
    }

    @Override
    public void onClick(View view) {

    }


}
